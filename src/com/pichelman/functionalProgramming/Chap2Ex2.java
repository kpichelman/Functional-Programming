package com.pichelman.functionalProgramming;

import option.None;
import option.Option;
import option.Some;

public class Chap2Ex2 {

	// Exercise 2.3
	
	/*
	 * This exercise is to modify some old code to use the
	 * Option class instead.  I included the Option class and 
	 * associated classes from the "code-examples" provided 
	 * by the books Author.
	 */
	
	
	public static void main(String[] args) {
		
		// Previous Code - Pre-Option class
        String stringObj = new String("This is our test string.");
        GenericObject<String> genericString = new GenericObject<String>();
        System.out.println("Value of null: " + genericString.getObj());
        genericString.setObj(stringObj);
        System.out.println("Value of genericString: " + genericString.getObj());
        
        // New Code with Option class - Note that all objects are FINAL!
        final GenericObjectWithOptionClass<String> genericStringWithOptionClass_NULL = new GenericObjectWithOptionClass<String>(null);
        System.out.println("Value of genericStringWithOptionClass_NULL: " + genericStringWithOptionClass_NULL.get());
        
        final GenericObjectWithOptionClass<String> genericStringWithOptionClass = new GenericObjectWithOptionClass<String>(stringObj);
        System.out.println("Value of genericStringWithOptionClass: " + genericStringWithOptionClass.get());    
	}
	
	// Original Class - Pre-Option class (See getObj method).
    static class GenericObject<T> {
        private Object obj = null;
        
        void setObj(T data) {
            obj = data;
        }
        
        @SuppressWarnings("unchecked")
        T getObj() {
            if (obj != null)
                return (T)obj;
            else
                return null;
        }
        
        boolean compairType(Object value) {
            return (obj.getClass().isInstance(value));
        }
    }
    
    // New Class using Option Class
    static class GenericObjectWithOptionClass<T> extends Option<T> {
        private Option<T> t;
        
        GenericObjectWithOptionClass(T data) {
            if (data == null) {
            	t = new None<T>();
            } else {
            	t = new Some<T>(data);
            } 
        }
        
        boolean compairType(Option<T> value) {
           if (!value.hasValue() && !t.hasValue()) {
        	   return true;
           } else {
        	   return t.get().getClass().isInstance(value.get().getClass());
           }
        }

		@Override
		public boolean hasValue() {
			return t.hasValue();
		}

		@SuppressWarnings("unchecked")
		@Override
		public T get() {
			if (t.hasValue()) {
				return t.get(); 
			} else {
				return (T)"No Value";
			}
		}
    }  
}
