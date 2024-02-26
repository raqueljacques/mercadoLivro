package com.mercadolivro.config

import com.mercadolivro.enums.Role
import com.mercadolivro.repository.CustomerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfig (
    //private val jwtUtil: JwtUtil,
    private val customerRepository: CustomerRepository,
    //private val authenticationFilter: AuthenticationFilter
) {

    private val PUBLIC_MATCHERS = arrayOf<String>()

    private val PUBLIC_POST_MATCHERS = arrayOf(
        "/customer"
    )

    private val ADMIN_MATCHERS = arrayOf(
        "/admin/**"
    )

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .sessionManagement{
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests
                    .anyRequest().permitAll()
                    //.requestMatchers(*PUBLIC_MATCHERS).permitAll()
                    //.requestMatchers(HttpMethod.POST, *PUBLIC_POST_MATCHERS).permitAll()
                    //.requestMatchers(*ADMIN_MATCHERS).hasAuthority(Role.ADMIN.description)
                    //.anyRequest().authenticated()
            }
            //.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun cryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}