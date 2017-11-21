/**
 * Copyright(C) 2016 Luvina Software Company
 * Common.java Sep 12, 2016 nguyenducthien
 */
package manager.thien.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import manager.thien.models.User;

/**
 * Các hàm dùng cho dự án
 * @author nguyenducthien
 *
 */
public class Common {

	   
	   /**
	 * Dùng để tính tổng số page bằng tổng số user/só lượng user/page
	 * @param totalUser int tổng số user
	 * @param size int số user/page
	 * @return tổng số page
	 */
	public static int getTotalPage(int totalUser, int size){
				return (int) Math.ceil((double) totalUser / size);
		   }
	   /**
	    * Tính dãy paging theo tổng số page, page hiện tại, số lượng page/ trang
	 * @param totalPage int tổng số page
	 * @param currentPage int page hiện tại
	 * @param pageNumber int số page hiển thị trên 1 trang
	 * @return List<Integer> page để hiển thị
	 */
	public static List<Integer> getListPage(int totalPage, int currentPage, int pageNumber) {
		   List<Integer> list = new ArrayList<>();
		   int haft = pageNumber/2;
		   if (totalPage > pageNumber) {
		   		if (currentPage <= haft){
		   			for (int i = 1; i <= pageNumber; i++) {
		   				list.add(i);
		   			}
		   		} else if (currentPage >= totalPage - haft){
		   			for (int i = totalPage - pageNumber + 1; i <= totalPage; i++) {
		   				list.add(i);
		   			}
		   		} 
		   		else {
		   			for (int i = currentPage - haft; i <= currentPage + haft; i++) {
		   				list.add(i);
		   			}
			   }
		   } else {
			   for ( int i = 1; i <= totalPage; i++) {
				   list.add(i);
			   }
		   }
		   return list;
	   }
	/** 
	 * Dùng để kiểm tra String có null hoặc rỗng hay không
	 * @param s String đầu vào
	 * @return True nếu rỗng hoặc null
	 */
	public static boolean isEmpty(String s) {
		return ("".equals(s) || s == null);
	}
	/**
	 * Dùng để kiểm tra ngày nhập vào có đúng định dạng hoặc tồn tại hay không
	 * @param date String date
	 * @return True nếu tồn tại và đúng định dạng dd/MM/yyyy
	 */
	public static boolean isValidDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		boolean isValid = true;
		try {
			format.setLenient(false);
			format.parse(date);
		} catch(ParseException ex) {
			isValid = false;
		}
		return isValid;
	}
	/**
	 * Dùng để kiểm tra ngày nhập vào có đúng định dạng hay không
	 * @param date String date
	 * @return True đúng định dạng dd/MM/yyyy
	 */
	public static boolean isRightFormat(String date) {
		String pattern = "^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$";
		if (Pattern.matches(pattern, date)) {
			return true;
		}
		return false;
	}
	/**
	 * Dùng để chuyển đổi String dd/MM/yyyy sang Date
	 * @param s String muốn chuyển đổi
	 * @return Date sau khi được chuyển đổi
	 */
	public static Date toDate(String s) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			date = format.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * Dùng để chuyển đổi Date thành String dưới dạng dd/MM/yyyy
	 * @param date Date
	 * @return String "dd/MM/yyyy"
	 */
	public static String dateInString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String s = format.format(date);
		return s;
	}
	/**
	 * Dùng để chuyển đổi tên dưới dạng ký tự latin, chữ đầu viết hoa, bỏ các dấu cách
	 * @param fullName
	 * @return String name sau khi được formatting
	 */
	public static String formattingName(String fullName) {
		String result = "";
		String temp = Normalizer.normalize(fullName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String rawName = pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d").toLowerCase().trim();
        String[] listName = rawName.split("\\s+");
        for (String name : listName) {
        	for (int i = 0; i < name.length(); i++) {
        		if (i == 0) {
        			result += (name.charAt(0) + "").toUpperCase();
        		} else {
        			result += name.charAt(i) + "";
        		}
        	}
        	result += " ";
        }
        return result.trim();
	}
	/**
	 * Hàm dùng để trả về login name
	 * VD Nguyễn Đức Thiện thành thiennd
	 * @param fullName
	 * @return trả về loginName
	 */
	public static String getLoginName(String fullName) {
		String result = "";
		String temp = Normalizer.normalize(fullName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String rawName = pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d").toLowerCase().trim();
        String[] listName = rawName.split("\\s+");
        result += listName[listName.length-1];
        for (int i = 0; i < listName.length - 1; i++) {
        	result += listName[i].charAt(0);
        }
        //Khi login name quá 15 ký tự
        if (result.length() > 15) {
        	result = result.substring(0, 15);
        }
        return result;
	}
	/** 
	 * Dùng để trả về mật khẩu cho fullName
	 * VD: Nguyen Duc Thien -> nguyenducthien
	 * @param fullName
	 * @return trả về password dựa trên fullName
	 */
	public static String getMD5Password(String fullName) {
		String result = "";
		String temp = Normalizer.normalize(fullName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String rawName = pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d").toLowerCase().trim();
        String[] listName = rawName.split("\\s+");
        for (String name : listName) {
        	result += name;
        }
        //Khi password quá 32 ký tự
        if (result.length() > 32) {
        	result = result.substring(0, 32);
        }
        return MD5(result);
	}
	/**
	 * Dùng để mã hóa MD5
	 * @param md5 String cần mã hóa
	 * @return trả về String đã được mã hóa dưới dạng MD5
	 */
	public static String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	/**
	 * Dùng để escape sql
	 * @param str String
	 * @return String sau khi được escape
	 */
	public static String sqlEscapeLike(String str) {
		String tem = str;
		//tem = tem.replace("//", "//////");
		tem = tem.replace("\\", "\\\\");
        tem = tem.replace("_", "\\_");
        tem = tem.replace("%", "\\%");
        return tem.trim();
	}
	/**
	 * Dùng để viết lên OutputStream
	 * @param out OutputStream
	 * @param s String cần viết
	 * @throws IOException
	 */
	public static void writeOutputStreamAndFlush(OutputStream  out, String s) throws IOException {
		out.write(s.getBytes());
		out.flush();
	}
	/**
	 * Dùng để viết lấy phần String body của file CSV
	 * @param listUser List<User>
	 * @param commas dùng để phần biệt giữa các cột
	 * @return String body CSV
	 */
	public static String getBodyCSVForListUser(List<User> listUser, String commas) {
		StringBuilder body = new StringBuilder();
		for (User user : listUser) {
			body.append(user.getFullName() + commas);
			body.append((("1".equals(user.getSex() + "")) ? "Nam" + commas : "Nữ" + commas));
			body.append((user.getBirthday() != null) ? dateInString(user.getBirthday()) + commas : commas);
			body.append(user.getInsurance().getCode() + commas);
			body.append(dateInString(user.getInsurance().getStartDate()) + commas);
			body.append(dateInString(user.getInsurance().getEndDate()) + commas);
			body.append(user.getInsurance().getPlaceRegister() + "\n");
		}
		return body.toString();
	}
	/** 
	 * Lấy một list Empty để dùng cho phần rỗng trong table
	 * @param list List phần tử
	 * @param max page size
	 * @return List empty
	 */
	public static List<String> getListEmpty(List<?> list,int max) {
		List<String> listEmpty = new ArrayList<String>();
		for (int i = 0; i < max - list.size(); i++) {
			listEmpty.add("" + i);
		}
		return listEmpty;
	}
}
