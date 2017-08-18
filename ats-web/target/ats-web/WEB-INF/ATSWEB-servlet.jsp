<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:context="http://www.springframework.org/schema/context"
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	   xmlns:mvc="http://www.springframework.org/schema/mvc"
	   xsi:schemaLocation="http://www.springframework.org/schema/beans
 						   http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
 						   http://www.springframework.org/schema/context
 					       http://www.springframework.org/schema/context/spring-context-4.0.xsd
 					       http://www.springframework.org/schema/mvc
						   http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">

	<context:component-scan base-package="com.ihs.ats.web.controller" />
	

	<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basename">
			<value>messages</value>
		</property>
	</bean>

	<bean id="dwrController" class="org.springframework.web.servlet.mvc.ServletWrappingController">
		<property name="servletClass">
			<value>org.directwebremoting.servlet.DwrServlet</value>
		</property>
		<property name="initParameters">
			<props>
				<prop key="debug">true</prop>
			</props>
		</property>
	</bean>

	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/jsp/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>

</beans>