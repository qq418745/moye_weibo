package top.moyeye.security;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * Mr.coala
 * 2020-03-02 16:20
 **/
public class Md5PasswordEncoder  implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return  DigestUtils.md5DigestAsHex(((String)charSequence).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return encodedPassword.equals(DigestUtils.md5DigestAsHex(((String)charSequence).getBytes(StandardCharsets.UTF_8))) ;
    }
}
