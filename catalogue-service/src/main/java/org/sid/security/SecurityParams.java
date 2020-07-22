package org.sid.security;

public interface SecurityParams {
    String JWT_HEADER_NAME="Authorization";
    String SECRET="ali.epi2017@gmail.com";
    long EXPIRATION=36000000;//1h le temps d'expiration
    String HEADER_PREFIX="Bearer ";

}
