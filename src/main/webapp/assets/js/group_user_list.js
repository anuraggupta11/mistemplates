$( document ).ready(function() {
	 
	backForGroup();
	
	addUserButton();
	
});
function addUserButton(){
	$('#addUserBtnId').unbind().click(function (e){
		$('#addUserModal').modal('show')
	});
}
 
function backForGroup(){
	
	$('.back-group-img').unbind().click(function (e){
		location.href="group.jsp";
	});
	 
}
