package ajia.domain;

public class Customer {

	private String address;
	
//	private PropertyChangeSupport propertyChangeSupport;
	
//	public Customer() {
//		propertyChangeSupport = new PropertyChangeSupport(this);
//	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
//		propertyChangeSupport.firePropertyChange("address", this.address, address);
		
		this.address = address;
	}
	
//	public void addPropertyChangeListener(PropertyChangeListener listener) {
//		propertyChangeSupport.addPropertyChangeListener(listener);
//	}
//	
//	public void removePropertyChangeListener(PropertyChangeListener listener) {
//		propertyChangeSupport.removePropertyChangeListener(listener);
//	}
	
}
