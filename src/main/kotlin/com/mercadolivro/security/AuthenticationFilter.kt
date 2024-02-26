package com.mercadolivro.security

import com.mercadolivro.repository.CustomerRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class SecurityFilter : OncePerRequestFilter() {
    //@Autowired
    //var tokenService: TokenService? = null

    @Autowired
    var customerRepository: CustomerRepository? = null

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = recoverToken(request)
        //if (token != null) {
            //val login: Unit = tokenService.validateToken(token)
            //val user: UserDetails = customerRepository.findByLogin(login)
            //val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)
            //SecurityContextHolder.getContext().authentication = authentication
        //}
        //filterChain.doFilter(request, response)
    }

    private fun recoverToken(request: HttpServletRequest): String? {
        val authHeader = request.getHeader("Authorization") ?: return null
        return authHeader.replace("Bearer ", "")
    }
}