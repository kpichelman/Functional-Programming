package option;

import option.None.NoneHasNoValue;

public abstract class Option<T> {
  public abstract boolean hasValue();
  
  public abstract T get();

  public T getOrElse(T alternative) {
    return hasValue() == true ? get() : alternative;
  }
  
  public static final Option<? extends Object> NONE = new Option<Object>() {

		public boolean hasValue() { return false; }
		public Object get() { throw new NoneHasNoValue(); }
		
		@Override
		public String toString() { return "None"; }

		@Override
		public boolean equals(Object other) {
			return (other == null || other.getClass() != None.class) ? false : true;
		}

		@Override
		public int hashCode() { return -1; }

	  };
}