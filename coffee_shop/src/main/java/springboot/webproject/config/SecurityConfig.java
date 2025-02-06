package springboot.webproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import springboot.webproject.service.CustomUserDetailsService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Security Filter Chain 설정
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/", "/login", "/users/**", "/css/**", "/js/**", "/images/**", "/product_images/**", "/roles/**", "/product/**", "/error/**","/notices/**").permitAll() // 인증 없이 접근 가능
                                .requestMatchers("/user/**", "/cart/**", "/order/**").hasAnyRole("USER", "ADMIN") // ROLE_USER만 접근 허용 - 로그인 된 유저
                                .requestMatchers("/**").hasRole("ADMIN") // ROLE_ADMIN만 접근 허용
//                        .requestMatchers("/**").hasAuthority("ROLE_ADMIN")
//                        .requestMatchers("/user/**").hasAuthority("ROLE_USER")
//                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                                .anyRequest().authenticated() // 나머지는 인증 필요
                )
                // 로그인 설정
//
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("usersId") // 사용자 ID 매핑
                        .passwordParameter("usersPw") // 비밀번호 매핑
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                // 로그아웃 설정
                .logout((logout) -> logout
                        .logoutUrl("/logout") // 로그아웃 요청 경로
                        .logoutSuccessUrl("/login") // 로그아웃 성공 후 이동할 경로
                        .invalidateHttpSession(true) // 세션 무효화
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        // 권한이 없을 경우 이동할 페이지 설정
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService) // CustomUserDetailsService 사용
                .passwordEncoder(passwordEncoder()); // 비밀번호 암호화 설정

        return authenticationManagerBuilder.build();
    }

    // PasswordEncoder 설정 (BCryptPasswordEncoder 사용)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}