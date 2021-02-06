package rs.ac.uns.ftn.email_service.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import rs.ac.uns.ftn.notification.Notification;
import rs.ac.uns.ftn.reject_notification.RejectNotification;

import javax.jws.WebService;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Component
@WebService(endpointInterface = "rs.ac.uns.ftn.email_service.soap.EmailService")
public class EmailServiceImpl implements EmailService {

    private static final String ORGAN_VLASTI = "Organ vlasti";

    private static final String OBAVESTENJE_SUBJECT = "Obaveštenje";

    private static final String OBAVESTENJE_HTML_NAME = "obavestenje.html";

    private static final String OBAVESTENJE_PDF_NAME = "obavestenje.pdf";

    private static final String REJECTED_ZAHTEV_SUBJECT = "Zahtev odbijen";

    private static final String POVERENIK = "Poverenik";

    private static final String RESENJE_SUBJECT = "Rešenje";

    private static final String RESENJE_HTML_NAME = "resenje.html";

    private static final String RESENJE_PDF_NAME = "resenje.pdf";

    private static final String ZALBA_SUBJECT = "Podneta nova žalba";

    private static final String ZALBA_HTML_NAME = "zalba.html";

    private static final String ZALBA_PDF_NAME = "zalba.pdf";

    private static final String ODGOVOR_NA_ZALBU = "Odgovor na žalbu";

    @Value("${email.organ.vlasti}")
    private String emailOfOrganVlasti;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Boolean sendObavestenje(Notification notification) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(notification.getReceiverEmail());
            helper.setFrom(new InternetAddress(notification.getSenderEmail(), ORGAN_VLASTI));

            helper.setSubject(OBAVESTENJE_SUBJECT);
            helper.setText(
                    "Poštovani, " +
                            "\n\nOdgovor na Vaš zahtev = \"" + notification.getDocumentId() + "\" se nalazi u prilogu. " +
                            "\n\nSrdačan pozdrav!");

            helper.addAttachment(OBAVESTENJE_PDF_NAME, new ByteArrayResource(notification.getPdfFile()));
            helper.addAttachment(OBAVESTENJE_HTML_NAME, new ByteArrayResource(notification.getHtmlFile()));

            javaMailSender.send(message);
            return true;
        } catch (MessagingException | IOException e) {
            return false;
        }
    }

    @Override
    public Boolean rejectZahtev(RejectNotification rejectNotification) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(rejectNotification.getReceiverEmail());
            helper.setFrom(new InternetAddress(rejectNotification.getSenderEmail(), ORGAN_VLASTI));

            helper.setSubject(REJECTED_ZAHTEV_SUBJECT);
            helper.setText("Poštovani, " + "\n\nVaš zahtev = \"" + rejectNotification.getZahtevId() + "\" je odbijen. " +
                    "\n\nSrdačan pozdrav!");

            javaMailSender.send(message);

            return true;
        } catch (MessagingException | IOException e) {
            return false;
        }
    }

    @Override
    public Boolean sendResenje(Notification notification) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = createMessageForResenje(message, notification);

            if (helper == null) {
                return false;
            }

            //send message to gradjanin
            helper.setTo(notification.getReceiverEmail());
            javaMailSender.send(message);

            //send message to organ vlasti
            helper.setTo(emailOfOrganVlasti);
            javaMailSender.send(message);

            return true;
        } catch (MessagingException e) {
            return false;
        }
    }

    private MimeMessageHelper createMessageForResenje(MimeMessage message, Notification notification) {

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setFrom(new InternetAddress(notification.getSenderEmail(), POVERENIK));

            helper.setSubject(RESENJE_SUBJECT);

            helper.setText(
                    "Poštovani, " +
                            "\n\nRešenje na žalbu = \"" + notification.getDocumentId() + "\" se nalazi u prilogu. " +
                            "\n\nSrdačan pozdrav!");

            helper.addAttachment(RESENJE_PDF_NAME, new ByteArrayResource(notification.getPdfFile()));
            helper.addAttachment(RESENJE_HTML_NAME, new ByteArrayResource(notification.getHtmlFile()));

            return helper;
        } catch (MessagingException | UnsupportedEncodingException e) {
            return null;
        }
    }

    @Override
    public Boolean sendZalba(Notification notification) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(emailOfOrganVlasti);
            helper.setFrom(new InternetAddress(notification.getSenderEmail(), POVERENIK));

            helper.setSubject(ZALBA_SUBJECT);
            helper.setText(
                    "Poštovani, " +
                            "\n\nPodneta je nova žalba na zahtev = \"" + notification.getDocumentId() + "\". " +
                            "\n\nSrdačan pozdrav!");

            helper.addAttachment(ZALBA_PDF_NAME, new ByteArrayResource(notification.getPdfFile()));
            helper.addAttachment(ZALBA_HTML_NAME, new ByteArrayResource(notification.getHtmlFile()));

            javaMailSender.send(message);

            simulateResponse(notification.getSenderEmail());

            return true;
        } catch (MessagingException | UnsupportedEncodingException | InterruptedException e) {
            return false;
        }
    }

    private void simulateResponse(String poverenikEmail) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(poverenikEmail);
            helper.setFrom(new InternetAddress(emailOfOrganVlasti, ORGAN_VLASTI));

            helper.setSubject(ODGOVOR_NA_ZALBU);
            helper.setText(
                    "Poštovani, " +
                            "\n\nSimulacija odgovora na podnetu žalbu ... " +
                            "\n\nSrdačan pozdrav!");

            javaMailSender.send(message);
        } catch (MessagingException | IOException e) {
            System.out.println("Sending email failed");
        }
    }
}
