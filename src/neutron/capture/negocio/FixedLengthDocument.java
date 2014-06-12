/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neutron.capture.negocio;

/**
 *
 * @author max
 */
    import javax.swing.text.AttributeSet;  
    import javax.swing.text.BadLocationException;  
    import javax.swing.text.PlainDocument;  
      
    public class FixedLengthDocument extends PlainDocument {  
        private int maxLength;  
      
        public FixedLengthDocument(int maxlen) {  
            super();  
              
            if (maxlen <= 0)  
                throw new IllegalArgumentException("You must specify a maximum length!");  
              
            maxLength = maxlen;  
        }  
      
        @Override  
        public void insertString(int offset, String str, AttributeSet attr)   
        throws BadLocationException {  
            if (str == null || getLength() == maxLength)  
                return;  
      
            int totalLen = (getLength() + str.length());  
            if (totalLen <= maxLength) {  
                super.insertString(offset, str, attr);  
                return;  
            }  
              
            String newStr = str.substring(0, (maxLength - getLength()));  
            super.insertString(offset, newStr, attr);  
        }  
    }  
