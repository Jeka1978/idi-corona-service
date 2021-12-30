package aop.examples.aop;

import aop.examples.validators.IdiException;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */


public class MailExceptionDistributor implements ExceptionDistributor {
    private List<String> mails;
    @Value("${dba.mails}")
    public void setMails(String[] mails) {
        this.mails = asList(mails);
    }

    @Override
    public void deliverException(IdiException ex) {
        for (String mail : mails) {
            System.out.println("mail with exception: " + ex.getMessage() + " sent to " + mail);
        }
    }
}
