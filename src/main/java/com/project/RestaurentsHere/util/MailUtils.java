package com.project.RestaurentsHere.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public static void send(String subject, String reciever, String body)
	{

		Properties properties = new Properties();
		properties.put("mail.smtp.port", "25");
		properties.put("mail.smtp.host", "jainnayana806@gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", true);

        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {   @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {   return new PasswordAuthentication(AppConstants.SENDER_EMAIL_ID,AppConstants.SENDER_EMAIL_PASSWORD);
            }
        });

        try
        {   MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(AppConstants.SENDER_EMAIL_ID));
            message.setRecipients(MimeMessage.RecipientType.TO,InternetAddress.parse(reciever));
            message.setSubject(subject);
            message.setContent(body,"text/html; charset=utf-8");
            Transport.send(message);
        }
        catch (MessagingException e)
        {   e.printStackTrace();
        }
	}

//	public static String emailBodyParticipant(String name, String room, String url) {
//		String head = "<html lang=\"en\">" +
//				"<head>" +
//				"<meta charset=\"utf-8\">" +
//				"<meta name=\"viewport\" content=\"width=device-width\">" +
//				"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
//				"<meta name=\"x-apple-disable-message-reformatting\">" +
//				"<title></title>" +
//				"<link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700\" rel=\"stylesheet\">" +
//				"<style>" +
//				"body,html{margin:0 auto!important;padding:0!important;height:100%!important;width:100%!important;background:#f1f1f1}*{-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}div[style*=\"margin: 16px 0\"]{margin:0!important}table,td{mso-table-lspace:0!important;mso-table-rspace:0!important}table{border-spacing:0!important;border-collapse:collapse!important;table-layout:fixed!important;margin:0 auto!important}img{-ms-interpolation-mode:bicubic}a{text-decoration:none}.aBn,.unstyle-auto-detected-links *,[x-apple-data-detectors]{border-bottom:0!important;cursor:default!important;color:inherit!important;text-decoration:none!important;font-size:inherit!important;font-family:inherit!important;font-weight:inherit!important;line-height:inherit!important}.a6S{display:none!important;opacity:.01!important}.im{color:inherit!important}img.g-img+div{display:none!important}@media only screen and (min-device-width:320px) and (max-device-width:374px){u~div .email-container{min-width:320px!important}}@media only screen and (min-device-width:375px) and (max-device-width:413px){u~div .email-container{min-width:375px!important}}@media only screen and (min-device-width:414px){u~div .email-container{min-width:414px!important}}" +
//				"</style>" +
//				"<style>" +
//				".primary{background:#30e3ca}.bg_white{background:#fff}.bg_light{background:#fafafa}.bg_black{background:#000}.bg_dark{background:rgba(0,0,0,.8)}.email-section{padding:2.5em}.btn{padding:10px 15px;display:inline-block}.btn.btn-primary{border-radius:5px;background:#30e3ca;color:#fff}.btn.btn-white{border-radius:5px;background:#fff;color:#000}.btn.btn-white-outline{border-radius:5px;background:0 0;border:1px solid #fff;color:#fff}.btn.btn-black-outline{border-radius:0;background:0 0;border:2px solid #000;color:#000;font-weight:700}h1,h2,h3,h4,h5,h6{font-family:Lato,sans-serif;color:#000;margin-top:0;font-weight:400}body{font-family:Lato,sans-serif;font-weight:400;font-size:15px;line-height:1.8;color:rgba(0,0,0,.4)}a{color:#30e3ca}.logo h1{margin:0}.logo h1 a{color:#30e3ca;font-size:24px;font-weight:700;font-family:Lato,sans-serif}.hero{position:relative;z-index:0}.hero .text{color:rgba(0,0,0,.3)}.hero .text h2{color:#000;font-size:40px;margin-bottom:0;font-weight:400;line-height:1.4}.hero .text h3{font-size:24px;font-weight:300}.hero .text h2 span{font-weight:600;color:#30e3ca}.heading-section h2{color:#000;font-size:28px;margin-top:0;line-height:1.4;font-weight:400}.heading-section .subheading{margin-bottom:20px!important;display:inline-block;font-size:13px;text-transform:uppercase;letter-spacing:2px;color:rgba(0,0,0,.4);position:relative}.heading-section .subheading::after{position:absolute;left:0;right:0;bottom:-10px;content:'';width:100%;height:2px;background:#30e3ca;margin:0 auto}.heading-section-white{color:rgba(255,255,255,.8)}.heading-section-white h2{font-family:line-height: 1;padding-bottom:0}.heading-section-white h2{color:#fff}.heading-section-white .subheading{margin-bottom:0;display:inline-block;font-size:13px;text-transform:uppercase;letter-spacing:2px;color:rgba(255,255,255,.4)}ul.social{padding:0}ul.social li{display:inline-block;margin-right:10px}.footer{border-top:1px solid rgba(0,0,0,.05);color:rgba(0,0,0,.5)}.footer .heading{color:#000;font-size:20px}.footer ul{margin:0;padding:0}.footer ul li{list-style:none;margin-bottom:10px}.footer ul li a{color:#000}" +
//				"</style>" +
//				"</head>";
//		String body = "<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #f1f1f1;\">" +
//				"<center style=\"width: 100%; background-color: #f1f1f1;\">" +
//				"<div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">" +
//				"<table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"margin: auto;\">" +
//				"<tr>" +
//				"<td valign=\"top\" class=\"bg_white\" style=\"padding: 1em 2.5em 0 2.5em;\">" +
//				"<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">" +
//				"<tr>" +
//				"<td class=\"logo\" style=\"text-align: center;\">" +
//				"<h1><a href=\"http://conference.cskaa.com\"><img src=\"http://cskaa.com/images/logo_blue2.png\" alt=\"Logo\"/></a></h1>" +
//				"</td>" +
//				"</tr>" +
//				"</table>" +
//				"</td>" +
//				"</tr>" +
//				"<tr>" +
//				"<td valign=\"middle\" class=\"hero bg_white\" style=\"padding: 2em 0 4em 0;\">" +
//				"<table>" +
//				"<tr>" +
//				"<td>" +
//				"<div class=\"text\" style=\"padding: 0 2.5em; text-align: center;\">" +
//				"<h2>Conference Invite</h2>" +
//				"<h3><b>" + name +"</b> is inviting you to join a video meeting for <b>"+room+"</b>.</h3>" +
//				"<p><a href=\""+url+"\" class=\"btn btn-primary\">Join Now</a></p>" +
//				"<p><a href=\""+url+"\">"+url+"</a></p>" +
//				"</div>" +
//				"</td>" +
//				"</tr>" +
//				"</table>" +
//				"</td>" +
//				"</tr>" +
//				"</table>" +
//				"</div>" +
//				"</center>" +
//				"</body>" +
//				"</html>";
//		return head+body;
//	}
//
//	public static String emailBodyRoomCreator(String room, String url) {
//		String head = "<html lang=\"en\">" +
//				"<head>" +
//				"<meta charset=\"utf-8\">" +
//				"<meta name=\"viewport\" content=\"width=device-width\">" +
//				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" +
//				"    <meta name=\"x-apple-disable-message-reformatting\">\r\n" +
//				"    <title></title>\r\n" +
//				"    <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700\" rel=\"stylesheet\">\r\n" +
//				"    <style>\r\n" +
//				"		body,html{margin:0 auto!important;padding:0!important;height:100%!important;width:100%!important;background:#f1f1f1}*{-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}div[style*=\"margin: 16px 0\"]{margin:0!important}table,td{mso-table-lspace:0!important;mso-table-rspace:0!important}table{border-spacing:0!important;border-collapse:collapse!important;table-layout:fixed!important;margin:0 auto!important}img{-ms-interpolation-mode:bicubic}a{text-decoration:none}.aBn,.unstyle-auto-detected-links *,[x-apple-data-detectors]{border-bottom:0!important;cursor:default!important;color:inherit!important;text-decoration:none!important;font-size:inherit!important;font-family:inherit!important;font-weight:inherit!important;line-height:inherit!important}.a6S{display:none!important;opacity:.01!important}.im{color:inherit!important}img.g-img+div{display:none!important}@media only screen and (min-device-width:320px) and (max-device-width:374px){u~div .email-container{min-width:320px!important}}@media only screen and (min-device-width:375px) and (max-device-width:413px){u~div .email-container{min-width:375px!important}}@media only screen and (min-device-width:414px){u~div .email-container{min-width:414px!important}}\r\n" +
//				"    </style>\r\n" +
//				"    <style>\r\n" +
//				"		.primary{background:#30e3ca}.bg_white{background:#fff}.bg_light{background:#fafafa}.bg_black{background:#000}.bg_dark{background:rgba(0,0,0,.8)}.email-section{padding:2.5em}.btn{padding:10px 15px;display:inline-block}.btn.btn-primary{border-radius:5px;background:#30e3ca;color:#fff}.btn.btn-white{border-radius:5px;background:#fff;color:#000}.btn.btn-white-outline{border-radius:5px;background:0 0;border:1px solid #fff;color:#fff}.btn.btn-black-outline{border-radius:0;background:0 0;border:2px solid #000;color:#000;font-weight:700}h1,h2,h3,h4,h5,h6{font-family:Lato,sans-serif;color:#000;margin-top:0;font-weight:400}body{font-family:Lato,sans-serif;font-weight:400;font-size:15px;line-height:1.8;color:rgba(0,0,0,.4)}a{color:#30e3ca}.logo h1{margin:0}.logo h1 a{color:#30e3ca;font-size:24px;font-weight:700;font-family:Lato,sans-serif}.hero{position:relative;z-index:0}.hero .text{color:rgba(0,0,0,.3)}.hero .text h2{color:#000;font-size:40px;margin-bottom:0;font-weight:400;line-height:1.4}.hero .text h3{font-size:24px;font-weight:300}.hero .text h2 span{font-weight:600;color:#30e3ca}.heading-section h2{color:#000;font-size:28px;margin-top:0;line-height:1.4;font-weight:400}.heading-section .subheading{margin-bottom:20px!important;display:inline-block;font-size:13px;text-transform:uppercase;letter-spacing:2px;color:rgba(0,0,0,.4);position:relative}.heading-section .subheading::after{position:absolute;left:0;right:0;bottom:-10px;content:'';width:100%;height:2px;background:#30e3ca;margin:0 auto}.heading-section-white{color:rgba(255,255,255,.8)}.heading-section-white h2{font-family:line-height: 1;padding-bottom:0}.heading-section-white h2{color:#fff}.heading-section-white .subheading{margin-bottom:0;display:inline-block;font-size:13px;text-transform:uppercase;letter-spacing:2px;color:rgba(255,255,255,.4)}ul.social{padding:0}ul.social li{display:inline-block;margin-right:10px}.footer{border-top:1px solid rgba(0,0,0,.05);color:rgba(0,0,0,.5)}.footer .heading{color:#000;font-size:20px}.footer ul{margin:0;padding:0}.footer ul li{list-style:none;margin-bottom:10px}.footer ul li a{color:#000}\r\n" +
//				"	</style>\r\n" +
//				"</head>";
//		String body = "<body width=\"100%\" style=\"margin: 0; padding: 0 !important; mso-line-height-rule: exactly; background-color: #f1f1f1;\">\r\n" +
//				"<center style=\"width: 100%; background-color: #f1f1f1;\">\r\n" +
//				"\r\n" +
//				"    <div style=\"max-width: 600px; margin: 0 auto;\" class=\"email-container\">\r\n" +
//				"        <table align=\"center\" role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\"\r\n" +
//				"               style=\"margin: auto;\">\r\n" +
//				"            <tr>\r\n" +
//				"                <td valign=\"top\" class=\"bg_white\" style=\"padding: 1em 2.5em 0 2.5em;\">\r\n" +
//				"                    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" +
//				"                        <tr>\r\n" +
//				"                            <td class=\"logo\" style=\"text-align: center;\">\r\n" +
//				"                                <h1><a href=\"http://conference.cskaa.com\"><img\r\n" +
//				"                                        src=\"http://cskaa.com/images/logo_blue2.png\" alt=\"Logo\"/></a></h1>\r\n" +
//				"                            </td>\r\n" +
//				"                        </tr>\r\n" +
//				"                    </table>\r\n" +
//				"                </td>\r\n" +
//				"            </tr>\r\n" +
//				"            <tr>\r\n" +
//				"                <td valign=\"middle\" class=\"hero bg_white\" style=\"padding: 2em 0 4em 0;\">\r\n" +
//				"                    <table>\r\n" +
//				"                        <tr>\r\n" +
//				"                            <td>\r\n" +
//				"                                <div class=\"text\" style=\"padding: 0 2.5em; text-align: center;\">\r\n" +
//				"                                    <h3>Thank you for using Modsuite event.</h3>\r\n" +
//				"                                    <h3>Your room name is <b>"+room+"</b>.</h3>\r\n" +
//				"                                    <h3>For inviting participants kindly send the below mentioned link to let them join the room. </h3>\r\n" +
//				"									<p>Participant Link - <a href=\""+url+"\">"+url+"</a></p>\r\n" +
//				"                                </div>\r\n" +
//				"                            </td>\r\n" +
//				"                        </tr>\r\n" +
//				"                    </table>\r\n" +
//				"                </td>\r\n" +
//				"            </tr>\r\n" +
//				"        </table>\r\n" +
//				"\r\n" +
//				"    </div>\r\n" +
//				"</center>\r\n" +
//				"</body>\r\n" +
//				"</html>";
//		return head+body;
//	}

}
