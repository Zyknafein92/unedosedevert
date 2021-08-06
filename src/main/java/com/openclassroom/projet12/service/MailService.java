package com.openclassroom.projet12.service;

import org.springframework.stereotype.Service;
import sendinblue.*;
import sendinblue.auth.*;
import sibApi.TransactionalEmailsApi;
import sibModel.*;
import sibApi.AccountApi;

import java.io.File;
import java.util.*;

@Service
public class MailService {

   public void sendEmail(String email, String link) {
       ApiClient defaultClient = Configuration.getDefaultApiClient();

       // Configure API key authorization: api-key
       ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
       apiKey.setApiKey("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");
       // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
       //apiKey.setApiKeyPrefix("Token");

       TransactionalEmailsApi apiInstance = new TransactionalEmailsApi();

       Long templateId = 1L; // Long | Id of the template
       SendSmtpEmail sendEmail = new SendSmtpEmail(); // SendEma
       ArrayList<SendSmtpEmailTo>recipients = new ArrayList<>();
       SendSmtpEmailTo recipient = new SendSmtpEmailTo();
       recipient.setEmail(email); // replace this with the recipient's email address
       recipient.setName("Jerome"); // replace this with the recipient's full name
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
