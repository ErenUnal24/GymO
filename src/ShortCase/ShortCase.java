package ShortCase;

import javax.swing.JOptionPane;

public class ShortCase {
	
	public static void showMessage(String str) {
		String message;
		
		switch(str) {
		case "fill":
			message = "There is an empty area.\nPlease fill all blanks..";
		case "success":
			message = "Successfull!!";
			break;
		default:
			message = str;
		}
		
		JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
	public static boolean confirm(String str) {
		String msg;
		switch(str) {
		case "sure":
			msg = "Are you sure?";
			break;
			default:
				msg = str;
				break;
		}
		
		int res = JOptionPane.showConfirmDialog(null,  msg, "Warning!", JOptionPane.YES_NO_OPTION);
		
		if(res == 0) {
			return true;
			
		}else {
			return false;
		}
	}
	

}
