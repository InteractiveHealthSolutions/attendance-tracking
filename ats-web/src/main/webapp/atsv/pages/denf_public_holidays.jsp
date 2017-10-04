<style>

</style>

<script>

function subfrm() {
	submitThisForm();
}

function submitThisForm() {
	//document.getElementById("submitBtn").disabled=true;
	document.getElementById("frm").submit();
}
</script>
<form method="post" id="frm" name="frm" >
<table class="denform-h">
	
	  <tr>
        <td> Holiday Type: <span class="mendatory-field">*</span></td>
     	<td>        	 
   	  <br>
          <spring:bind path="command.typePH">
     
        <select id="HolidayType" name="${status.expression}" bind-value="${status.value}">
               	<option>Annual</option>
               	<option>Casual</option>               	
               	<option>Sick</option>
            	    	
           </select>
        	<span class="error-message"><c:out	value="${status.errorMessage}" /></span>
        	</spring:bind>
			</td>
    	</tr>
    
    <tr>
        <td> Date : <span class="mendatory-field">*</span></td>
     <td>        	 <br>
          <spring:bind path="command.datePH">
          <input type="date" id="datePH" name="${status.expression}" maxlength="30" />
	      <span class="error-message"><c:out	value="${status.errorMessage}" /></span>
        	</spring:bind>
		</td>
    </tr>
    
    <tr>
	 <td><input type="button" id="submitBtn" value="Submit Data" onclick="subfrm()"></td>
	</tr>
	

</table>
</form>
