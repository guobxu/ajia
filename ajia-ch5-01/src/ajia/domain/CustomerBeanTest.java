package ajia.domain;

import static org.junit.Assert.assertEquals;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class CustomerBeanTest {

	@Test
	public void addressChangeNotif() {
		Customer testCustomer = new Customer();
		testCustomer.setAddress("oldAddress");
		final AtomicInteger counter = new AtomicInteger();
		testCustomer.addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				assertEquals("address", evt.getPropertyName());
				assertEquals("oldAddress", evt.getOldValue());
				assertEquals("newAddress", evt.getNewValue());
				
				counter.incrementAndGet();
			}
			
		});
		
		testCustomer.setAddress("newAddress");
		assertEquals(1, counter.get());
	}

}
