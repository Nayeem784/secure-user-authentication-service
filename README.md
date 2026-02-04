# Secure User Authentication Service

## Authentication vs Authorization
Authentication verifies who the user is.
Authorization verifies what the user can access.

## Login Flow
1. User calls /auth/login
2. AuthenticationManager validates credentials
3. CustomUserDetailsService loads user
4. PasswordEncoder validates password
5. JWT is generated and returned

## JWT Validation
- JWT sent in Authorization header
- JwtAuthenticationFilter validates token
- SecurityContext is populated
- Access granted based on role

## Security Rules
/auth/login → public  
/api/users/** → ROLE_USER, ROLE_ADMIN  
/api/admin/** → ROLE_ADMIN  

## Security Features
- JWT based
- Stateless APIs
- Password encryption
- Role-based authorization
