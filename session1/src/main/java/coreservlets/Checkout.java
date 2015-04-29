package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Checkout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
	    ShoppingCart cart;
	    synchronized(session) {
	      cart = (ShoppingCart)session.getAttribute("shoppingCart");
	      if (cart == null) {
	        cart = new ShoppingCart();
	        session.setAttribute("shoppingCart", cart);
	      }
	      String itemID = request.getParameter("itemID");
	      if (itemID != null) {
	        String numItemsString =
	          request.getParameter("numItems");
	        if (numItemsString == null) {
	          cart.addItem(itemID);
	        } 
	        else {
	          int numItems;
	          try {
	            numItems = Integer.parseInt(numItemsString);
	          } catch(NumberFormatException nfe) {
	            numItems = 1;
	          }
	          cart.setNumOrdered(itemID, numItems);
	        }
	      }
	    }	    
		//Een lijst met de items weergeven
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Checkout your order";
		String docType ="<!DOCTYPE HTML>\n";
		out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
		synchronized(session) {
	      List<ItemOrder> itemsOrdered = cart.getItemsOrdered();
	      if (itemsOrdered.size() == 0) {
	        out.println("<H2><I>You have no items to checkout.</I></H2>");
	      } 
	      else {
	        out.println
	          ("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
	           "<TR BGCOLOR=\"#FFAD00\">\n" +
	           "  <TH>Item ID<TH>Description\n" +
	           "  <TH>Unit Cost<TH>Number<TH>Total Cost");
	        ItemOrder order;
	        NumberFormat formatter = NumberFormat.getCurrencyInstance();
	        for(int i=0; i<itemsOrdered.size(); i++) {
	          order = itemsOrdered.get(i);
	          out.println
	            ("<TR>\n" +
	             "  <TD>" + order.getItemID() + "\n" +
	             "  <TD>" + order.getShortDescription() + "\n" +
	             "  <TD>" +
	             formatter.format(order.getUnitCost()) + "\n" +
	             "  <TD>" +
	             "<FORM>\n" +  // Submit to current URL
	             "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
	             "       VALUE=\"" + order.getItemID() + "\">\n" +
	             "<INPUT TYPE=\"TEXT\" NAME=\"numItems\"\n" +
	             "       SIZE=3 VALUE=\"" + 
	             order.getNumItems() + "\">\n" +
	             "<SMALL>\n" +
	             "<INPUT TYPE=\"SUBMIT\"\n "+
	             "       VALUE=\"Update Order\">\n" +
	             "</SMALL>\n" +
	             "</FORM>\n" +
	             "  <TD>" +
	             formatter.format(order.getTotalCost()));
	        }
	        out.println("</TABLE>\n");
			//-----Een knop om alle items te verwijderen en zo te betalen-----
	        String checkoutURL = response.encodeURL("pay");
	        out.println
	        ("</TABLE>\n" +
	         "<FORM ACTION=\"" + checkoutURL + "\">\n" +
	         "<BIG><CENTER>\n" +
	         "<INPUT TYPE=\"SUBMIT\"\n" +
	         "       VALUE=\"I agree to buy these orders\">\n" +
	         "</CENTER></BIG></FORM>");	  
	        }    
            out.println("</BODY></HTML>");
		}
	}
}
