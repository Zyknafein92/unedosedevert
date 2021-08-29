package com.openclassroom.projet12.service;

import org.springframework.stereotype.Service;
import sendinblue.*;
import sendinblue.auth.*;
import sibApi.TransactionalEmailsApi;
import sibModel.*;
import java.util.*;

@Service
public class MailService {

   public void sendEmail(String email, String link) {
       ApiClient defaultClient = Configuration.getDefaultApiClient();

       // Configure API key authorization: api-key
       ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
       apiKey.setApiKey("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");

       TransactionalEmailsApi apiInstance = new TransactionalEmailsApi();

       Long templateId = 1L;
       SendSmtpEmail sendEmail = new SendSmtpEmail();
       ArrayList<SendSmtpEmailTo>recipients = new ArrayList<>();
       SendSmtpEmailTo recipient = new SendSmtpEmailTo();
       recipient.setEmail(email);
       recipient.setName("Cher Client");
       recipients.add(recipient);


       Map<String, String> params = new HashMap<>();
       params.put("link", link);
       sendEmail.setParams(params);
       sendEmail.setTemplateId(templateId);
       sendEmail.setTo(recipients);
       try {
           CreateSmtpEmail createSmtpEmail = apiInstance.sendTransacEmail(sendEmail);
           System.out.println(createSmtpEmail);
       } catch (ApiException e) {
           System.err.println("Exception when calling TransactionalEmailsApi#sendTemplate");
           e.printStackTrace();
       }

   }
}
