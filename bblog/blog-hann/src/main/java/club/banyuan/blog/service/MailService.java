package club.banyuan.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTestMail(String reservice, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(reservice);
        simpleMailMessage.setSubject("spring mail text");
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom("zyf_supergirl123@qq.com");

        javaMailSender.send(simpleMailMessage);
    }
}
