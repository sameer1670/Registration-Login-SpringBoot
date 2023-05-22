//package com.example.registrationandlogin.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//// @Configuration
//// @EnableWebSecurity
//public class SecurityConfiguration {
//
////    @Autowired
////    private UserDetailsService userDetailsService;
//
//    // @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests((authorize) ->
//                        authorize
//                                // .requestMatchers("/register/**").permitAll()
//                                // .requestMatchers("/index").permitAll()
//                                // .requestMatchers("/users").hasRole("ADMIN")
//                                .requestMatchers("/*").permitAll()
//                ).formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/index")
//                                .permitAll()
//                ).logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll()
//                );
//        return http.build();
//    }
//}
