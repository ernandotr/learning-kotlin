package dev.ernando

import jakarta.mail.Authenticator
import jakarta.mail.Message
import jakarta.mail.PasswordAuthentication
import jakarta.mail.Session
import jakarta.mail.Transport
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeMessage
import java.util.*

fun main() {
  println("Sending email...")

  val properties = Properties()
  properties["mail.smtp.auth"] = "true"
  properties["mail.smtp.host"] = "smtp.gmail.com"
  properties["mail.smtp.port"] = "465"
  properties["mail.smtp.socketFactory.port"] = "465"
  properties["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"

   val session = Session.getInstance(properties, object : Authenticator() {
     override fun getPasswordAuthentication(): PasswordAuthentication {
       return PasswordAuthentication("USER_NAME", "PASSWORD")
     }
   })

//  val session = Session.getInstance(properties, SMTPAuth("dev.completo@gmail.com", "otopgxnidckwcxto"))
  
  val message = MimeMessage(session)
  message.setFrom(InternetAddress.parse("SENDER")[0])
  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("RECEIVER"))
  message.subject = "Test"
  message.setText("Hello, this is another test email")

  Transport.send(message)
  println("Email sent!")

}

//private class SMTPAuth(val username: String, val password: String) : Authenticator() {
//  override fun getPasswordAuthentication(): PasswordAuthentication {
//    return PasswordAuthentication(username, password)
//  }
//}
