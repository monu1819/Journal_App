package com.bawp.self;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;
import java.io.File;
import java.util.Properties;

public class MailReaderService {
    public String getLastMailId() throws Exception {

        try {
            Properties props = new Properties();
            props.setProperty("mail.imap.ssl.enable", "true");
            Session mailSession = Session.getInstance(props);
            mailSession.setDebug(true);
            Store mailStore = mailSession.getStore("imap");
            mailStore.connect("outlook.live.com", "atishmo@outlook.co", "atfsdjkf");
            if (mailStore.isConnected())
                System.out.println("voila");
            Folder folder = mailStore.getFolder("Inbox");
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));


            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
