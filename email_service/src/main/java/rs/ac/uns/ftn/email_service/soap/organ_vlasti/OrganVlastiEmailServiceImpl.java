package rs.ac.uns.ftn.email_service.soap.organ_vlasti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import rs.ac.uns.ftn.obavestenje_notification.ObavestenjeNotification;
import rs.ac.uns.ftn.reject_notification.RejectNotification;

import javax.jws.WebService;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@WebService(endpointInterface = "rs.ac.uns.ftn.email_service.soap.organ_vlasti.OrganVlastiEmailService")
public class OrganVlastiEmailServiceImpl implements OrganVlastiEmailService {

    private static final String ORGAN_VLASTI = "Organ vlasti";

    private static final String OBAVESTENJE_SUBJECT = "Obaveštenje";

    private static final String OBAVESTENJE_HTML_NAME = "obavestenje.html";

    private static final String OBAVESTENJE_PDF_NAME = "obavestenje.pdf";

    private static final String REJECTED_ZAHTEV_SUBJECT = "Zahtev odbijen";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Boolean sendObavestenje(ObavestenjeNotification notification) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(notification.getReceiverEmail());
            helper.setFrom(new InternetAddress(notification.getSenderEmail(), ORGAN_VLASTI));

            helper.setSubject(OBAVESTENJE_SUBJECT);
            helper.setText(
                    "Poštovani, " +
                            "\n\nOdgovor na Vaš zahtev = \"" + notification.getZahtevId() + "\" se nalazi u prilogu. " +
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
}
