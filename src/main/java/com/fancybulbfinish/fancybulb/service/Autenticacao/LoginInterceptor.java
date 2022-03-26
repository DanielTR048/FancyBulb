package com.fancybulbfinish.fancybulb.service.Autenticacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fancybulbfinish.fancybulb.service.CookieService;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
      
      try{
         if(CookieService.getCookie(request, "usuariosId") != null){
            return true;
         }
      }
      catch(Exception erro) {
         response.sendRedirect("/Login-page");
      }
      
      response.sendRedirect("/Login-page");
      return false;
   }

   // @Override
   // public void postHandle(HttpServletRequest request, HttpServletResponse response, 
   //    Object handler, ModelAndView modelAndView) throws Exception {
      
   //    System.out.println("Post Handle method is Calling");
   // }
   // @Override
   // public void afterCompletion
   //    (HttpServletRequest request, HttpServletResponse response, Object 
   //    handler, Exception exception) throws Exception {
      
   //    System.out.println("Request and Response is completed");
   // }
}