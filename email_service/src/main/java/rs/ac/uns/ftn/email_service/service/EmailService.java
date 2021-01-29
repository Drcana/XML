package rs.ac.uns.ftn.email_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.email_service.dto.ObavestenjeEmailDto;
import rs.ac.uns.ftn.email_service.dto.RejectZahtevDto;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    private static final String ORGAN_VLASTI = "Organ vlasti";

    private static final String OBAVESTENJE_SUBJECT = "Obaveštenje";

    private static final String OBAVESTENJE_HTML_NAME = "obavestenje.html";

    private static final String OBAVESTENJE_PDF_NAME = "obavestenje.pdf";

    private static final String REJECTED_ZAHTEV_SUBJECT = "Zahtev odbijen";

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendObavestenje(ObavestenjeEmailDto obavestenjeEmailDto) {
        String response;
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(obavestenjeEmailDto.getReceiverEmail());
            helper.setFrom(new InternetAddress(obavestenjeEmailDto.getSenderEmail(), ORGAN_VLASTI));

            helper.setSubject(OBAVESTENJE_SUBJECT);
            helper.setText(
                    "Poštovani, " +
                            "\n\nOdgovor na Vaš zahtev = \"" + obavestenjeEmailDto.getZahtevId() + "\"se nalazi u prilogu. " +
                            "\n\nSrdačan pozdrav");

            helper.addAttachment(obavestenjeEmailDto.isPdfFile() ? OBAVESTENJE_PDF_NAME : OBAVESTENJE_HTML_NAME,
                    new ByteArrayResource(obavestenjeEmailDto.getFile()));

            javaMailSender.send(message);
            response = "Email has been sent to :" + obavestenjeEmailDto.getReceiverEmail();
        } catch (MessagingException | IOException e) {
            response = "Email send failure to :" + obavestenjeEmailDto.getReceiverEmail();
        }

        return response;
    }

    public String rejectZahtev(RejectZahtevDto rejectZahtevDto) {
        String response;
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.setTo(rejectZahtevDto.getReceiverEmail());
            helper.setFrom(new InternetAddress(rejectZahtevDto.getSenderEmail(), ORGAN_VLASTI));

            helper.setSubject(REJECTED_ZAHTEV_SUBJECT);
            helper.setText("Poštovani, " + "\n\nVaš zahtev = " + rejectZahtevDto.getZahtevId() + " je odbijen. " +
                    "\n\nSrdačan pozdrav!");

            javaMailSender.send(message);

            response = "Email has been sent to :" + rejectZahtevDto.getReceiverEmail();
        } catch (MessagingException | IOException e) {
            response = "Email send failure to :" + rejectZahtevDto.getReceiverEmail();
        }

        return response;
    }
}
