//package com.example.demo.config;
//
//import com.longtu.dap.web.rbac.shiro.AuthWebFilter;
//import com.longtu.dap.web.rbac.shiro.DomainJdbcRealm;
//import com.longtu.dap.web.rbac.shiro.StatelessDefaultSubjectFactory;
//import com.longtu.dap.web.rbac.shiro.redis.RedisManager;
//import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
//import org.apache.shiro.mgt.DefaultSubjectDAO;
//import org.apache.shiro.session.mgt.DefaultSessionManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.filter.authc.AnonymousFilter;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.Filter;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//	private Logger loader = LoggerFactory.getLogger(ShiroConfig.class);
//
//	/**
//	 * FilterRegistrationBean
//	 *
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//		filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
//		filterRegistration.setEnabled(true);
//		filterRegistration.addUrlPatterns("/*");
//		filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
//		return filterRegistration;
//	}
//
//	/**
//	 * @return
//	 * @see org.apache.shiro.spring.web.ShiroFilterFactoryBean
//	 */
//	@Bean(name = "shiroFilter")
//	public ShiroFilterFactoryBean shiroFilter() {
//		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//		bean.setSecurityManager(securityManager());
//		// bean.setLoginUrl("/login");
//		// bean.setUnauthorizedUrl("/unauthor");
//
//		Map<String, Filter> filters = Maps.newHashMap();
//		filters.put("anon", new AnonymousFilter());
//		filters.put("authc", shiroWebFilter());
//		bean.setFilters(filters);
//
//		// Map<String, String> chains = Maps.newHashMap();
//		// chains.put("/login/login.do", "anon");
//		// chains.put("/login/getCode.do", "anon");
//		// chains.put("/user/register.do", "anon");
//		// chains.put("/user/checkUsername.do", "anon");
//		// chains.put("/user/resetPassword.do", "anon");
//		// chains.put("/user/retrievePassword.do", "anon");
//		// chains.put("/user/saveLeavingMessage.do", "anon");
//		// chains.put("/layer/**", "anon");
//		// chains.put("/**", "authc");
//
//		String chains = "/login/**=anon\n"
//				+ "/login2/**=anon\n"
//				+ "/user/register.do=anon\n"
//				+ "/register/**=anon\n"
//				+ "/share/**=anon\n"
//				+ "/visitor/**=anon\n"
//				+ "/user/register.do=anon\n"
//				+ "/user/checkUsername.do=anon\n"
//				+ "/user/resetPassword.do=anon\n"
//				+ "/user/retrievePassword.do=anon\n"
//				+ "/user/saveLeavingMessage.do=anon\n"
//				+ "/register/*.do=anon\n"
//				+ "/layer/**=anon\n"
//				+ "/**=authc\n";
//
//		bean.setFilterChainDefinitions(chains);
//
//		return bean;
//	}
//
//	/**
//	 * @return
//	 * @see org.apache.shiro.mgt.SecurityManager
//	 */
//	@Bean(name = "securityManager")
//	public DefaultWebSecurityManager securityManager() {
//		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//		manager.setRealm(userRealm());
//		((DefaultSessionStorageEvaluator) (((DefaultSubjectDAO) manager.getSubjectDAO()).getSessionStorageEvaluator()))
//				.setSessionStorageEnabled(false);
//		manager.setSubjectFactory(statelessDefaultSubjectFactory());
//		manager.setSessionManager(defaultSessionManager());
//		// manager.setCacheManager(cacheManager());
//		// manager.setSessionManager(defaultWebSessionManager());
//		return manager;
//	}
//	@Bean(name = "subjectFactory")
//	public StatelessDefaultSubjectFactory statelessDefaultSubjectFactory() {
//		StatelessDefaultSubjectFactory factory = new StatelessDefaultSubjectFactory();
//		return factory;
//	}
//
//	/**
//	 * @return
//	 * @see DefaultWebSessionManager
//	 */
//	@Bean(name = "sessionManager")
//	public DefaultSessionManager defaultSessionManager() {
//		DefaultSessionManager sessionManager = new DefaultSessionManager();
//		sessionManager.setSessionValidationSchedulerEnabled(false);
//		return sessionManager;
//	}
//	@Bean(name = "redisManager")
//	public RedisManager redisManager() {
//		RedisManager redis = new RedisManager();
//		redis.setHost("dap16");
//		redis.setPort(6379);
//		redis.setExpire(1800);
//		redis.setPassword("TJ@nano.2016&*");
//		return redis;
//	}
//	/**
//	 * @return
//	 * @see UserRealm--->AuthorizingRealm
//	 */
//	@Bean
//	@DependsOn(value = "lifecycleBeanPostProcessor")
//	public DomainJdbcRealm userRealm() {
//		DomainJdbcRealm userRealm = new DomainJdbcRealm();
//		// userRealm.setCacheManager(cacheManager());
//		return userRealm;
//	}
//
//	// @Bean
//	// public URLPermissionsFilter urlPermissionsFilter() {
//	// return new URLPermissionsFilter();
//	// }
//
//	@Bean
//	public AuthWebFilter shiroWebFilter() {
//		return new AuthWebFilter();
//	}
//
//	// @Bean
//	// public EhCacheManager cacheManager() {
//	// EhCacheManager cacheManager = new EhCacheManager();
//	// cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
//	// return cacheManager;
//	// }
//
//	@Bean
//	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//		return new LifecycleBeanPostProcessor();
//	}
//
//	@Bean
//	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//		daap.setProxyTargetClass(true);
//		return daap;
//	}
//}
