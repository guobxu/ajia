package ajia.bean;

import java.beans.Introspector;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.commons.beanutils.BeanUtils;

import ajia.domain.Customer;

public aspect BeanMakerAspect {

	private PropertyChangeSupport Customer.propertyChangeSupport;
	
	public void Customer.addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
	
	public void Customer.removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	pointcut beanCreation(Customer bean) : initialization(Customer+.new(..)) && this(bean);
	
	pointcut beanPropertyChange(Customer bean, Object newVal) : execution(void Customer+.set*(*))
			&& this(bean) && args(newVal);
	
	after(Customer bean) returning : beanCreation(bean) {
		bean.propertyChangeSupport = new PropertyChangeSupport(bean);
	}
	
	void around(Customer bean, Object newVal) : beanPropertyChange(bean, newVal) {
		String methodName = thisJoinPointStaticPart.getSignature().getName();
		String propertyName = Introspector.decapitalize(methodName.substring(3));
		Object oldVal = getPropertyValue(bean, propertyName);
		proceed(bean, newVal);
		bean.propertyChangeSupport.firePropertyChange(propertyName, oldVal, newVal);
	}
	
	private static Object getPropertyValue(Object bean, String propertyName) {
		try {
			return BeanUtils.getProperty(bean, propertyName);
		} catch(Exception ex) {
			return null;
		}
	}
 	
}
