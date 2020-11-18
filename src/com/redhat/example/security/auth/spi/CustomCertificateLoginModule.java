package com.redhat.example.security.auth.spi;

import javax.security.cert.X509Certificate;
import javax.security.auth.login.LoginException;

import org.apache.activemq.artemis.spi.core.security.jaas.CertificateLoginModule;

import java.util.Set;
import java.util.HashSet;


public class CustomCertificateLoginModule extends CertificateLoginModule
{
    public String getUserNameForCertificates(X509Certificate[] certs) throws LoginException {
        System.out.print("*** CustomCertificateLoginModule.getUserNameForCertificates()\n");
        System.out.printf("\tcerts[0].getSubjectDN().getName():%s\n", certs[0].getSubjectDN().getName());
        String fullName = certs[0].getSubjectDN().getName();

        int start = fullName.indexOf("CN=");
        int end = fullName.indexOf(",", start);
        if (end == -1) {
            end = fullName.length();
        }
        String username = fullName.substring(start + 3, end);
        System.out.printf("username: %s\n", username);
        return username;
    }

    public Set<String> getUserRoles(String username) throws LoginException {
        System.out.printf("*** CustomCertificateLoginModule.getUserRoles(%s)\n", username);
        Set<String> roles = new HashSet<String>();
        roles.add("amq");
        roles.add(username);
        return roles;
    }

}
