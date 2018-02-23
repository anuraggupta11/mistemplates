 $(document).ready(function() {

	backImageForGroup();
	setupMultiSelectDropDown();
	handleClickOnViksitMultiDropDown();
	addUserFormValidation();

});
function addUserFormValidation() {
	$('#emailId')
			.unbind()
			.keyup(
					function(e) {
						e.stopPropagation();
						var email = $(this).val();
						var email_div = $(this);

						if (validateEmail(email) && email.length !== '') {
							$
									.get(
											"http://192.168.1.13:8080/istar/rest/user/validate/email/"
													+ email,
											function(data) {
												var temp = "This email is valid";
												$('#emailMessageId').text(
														data.data.message);
												if (data.data.message === temp) {
													if (!email_div
															.hasClass("form-control-success")) {
														// console.log($(this));
														email_div
																.removeClass("form-control-danger");
														email_div
																.parent()
																.removeClass(
																		"has-danger");
														email_div
																.parent()
																.addClass(
																		"has-success");
														email_div
																.addClass("form-control-success");

													}
												} else {
													if (email_div
															.hasClass("form-control-success")) {
														email_div
																.removeClass("form-control-success");
														email_div
																.parent()
																.removeClass(
																		"has-success");
														email_div
																.parent()
																.addClass(
																		"has-danger");
														email_div
																.addClass("form-control-danger");
													}

												}
											});
						} else {
							email_div.removeClass("form-control-success");
							email_div.parent().removeClass("has-success");
							email_div.parent().addClass("has-danger");
							email_div.addClass("form-control-danger");
							$('#emailMessageId').text('');
						}
					});
	$('#phoneNo')
			.unbind()
			.keyup(
					function(e) {
						e.stopPropagation();
						var phone_no = $(this).val();
						var phone_div = $(this);
						if (phone_no.length == 10 && validatePhone(phone_no)) {

							$
									.get(
											"http://192.168.1.13:8080/istar/rest/user/validate/mobile/"
													+ phone_no,
											function(data) {
												var temp = "This mobile is valid";
												$('#phonenoMessageId').text(
														data.data.message);
												if (data.data.message === temp) {
													if (!phone_div
															.hasClass("form-control-success")) {
														// console.log($(this));
														phone_div
																.removeClass("form-control-danger");
														phone_div
																.parent()
																.removeClass(
																		"has-danger");
														phone_div
																.parent()
																.addClass(
																		"has-success");
														phone_div
																.addClass("form-control-success");

													}
												} else {
													if (phone_div
															.hasClass("form-control-success")) {
														phone_div
																.removeClass("form-control-success");
														phone_div
																.parent()
																.removeClass(
																		"has-success");
														phone_div
																.parent()
																.addClass(
																		"has-danger");
														phone_div
																.addClass("form-control-danger");
													}

												}
											});

						} else {
							phone_div.removeClass("form-control-success");
							phone_div.parent().removeClass("has-success");
							phone_div.parent().addClass("has-danger");
							phone_div.addClass("form-control-danger");
							$('#phonenoMessageId').text("");
						}

					});
	$('#pinCode')
			.unbind()
			.keyup(
					function(e) {
						e.stopPropagation();
						var pin_code = $(this).val();
						var pin_div = $(this);
						if (pin_code.length == 6) {
							$
									.get(
											"http://192.168.1.13:8080/istar/rest/user/validate/pincode/"
													+ pin_code,
											function(data) {

												var temp = "Is_Valid";
												if (data.data === temp) {
													$('#pincodeMessageId')
															.text(
																	"Pincode is valid");
													if (!pin_div
															.hasClass("form-control-success")) {
														// console.log($(this));
														pin_div
																.removeClass("form-control-danger");
														pin_div
																.parent()
																.removeClass(
																		"has-danger");
														pin_div
																.parent()
																.addClass(
																		"has-success");
														pin_div
																.addClass("form-control-success");

													}

												} else {
													$('#pincodeMessageId')
															.text(
																	"Pincode is not valid");
													if (pin_div
															.hasClass("form-control-success")) {
														pin_div
																.removeClass("form-control-success");
														pin_div
																.parent()
																.removeClass(
																		"has-success");
														pin_div
																.parent()
																.addClass(
																		"has-danger");
														pin_div
																.addClass("form-control-danger");
													}

												}
											});
						} else {

							pin_div.removeClass("form-control-success");
							pin_div.parent().removeClass("has-success");
							pin_div.parent().addClass("has-danger");
							pin_div.addClass("form-control-danger");
							$('#pincodeMessageId').text("");
						}

					});
}

function backImageForGroup() {

	$('.back-group-img').unbind().click(function(e) {
		location.href = "group.jsp";
	});

}

function validateEmail(sEmail) {
	var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	if (filter.test(sEmail)) {
		return true;
	} else {
		return false;
	}
}
function validatePhone(input_value) {
	var phone_pattern = /([0-9]{10})|(\([0-9]{3}\)\s+[0-9]{3}\-[0-9]{4})/;
	if (phone_pattern.test(input_value)) {
		return true;
	} else {
		return false;
	}
}

function setupMultiSelectDropDown() {
	$('.viksit-multiselect-dropdown > .btn').addClass("w-100");
	$('.viksit-multiselect-dropdown > .dropdown-menu').addClass(
			"scroll-dropdown-create-user");

	$('.vikisit_search_dropdown_multiselect').unbind().keyup(function() {
		var search_term = $(this).val();
		iterate_drop_down($(this), search_term);
	});

}
function iterate_drop_down(search_elem, search_term) {
	$(search_elem).parent().siblings('.dropdown-item').each(
			function() {
				if (search_term !== "") {

					var options = $(this).text().trim();
					if (options.trim().toLowerCase().indexOf(
							search_term.trim().toLowerCase()) > -1) {
						$(this).show();
					} else {
						$(this).hide();
					}
				} else {
					$(this).show();
				}
			});
}
function handleClickOnViksitMultiDropDown() {

	var jobRoles = [];
	var units = [];
	var licenses = [];
	var section_groups = [];

	$('#unit>.viksit-multiselect-dropdown >.dropdown-menu>.dropdown-item')
			.unbind().click(function(e) {
				e.stopPropagation();
				units.push($(this).data('listid'));
				console.log(units);

				var find_div = $(this).find('svg');
				if (find_div.hasClass('white')) {
					find_div.removeClass('white');
					find_div.css('color', 'red');
				} else {
					find_div.addClass('white');
				}

			});
	$('#jobRole>.viksit-multiselect-dropdown >.dropdown-menu>.dropdown-item')
			.unbind().click(function(e) {
				e.stopPropagation();
				jobRoles.push($(this).data('listid'));
				console.log(jobRoles);
				var find_div = $(this).find('svg');
				if (find_div.hasClass('white')) {
					find_div.removeClass('white');
					find_div.css('color', 'red');
				} else {
					find_div.addClass('white');
				}
			});
	$('#groups>.viksit-multiselect-dropdown >.dropdown-menu>.dropdown-item')
			.unbind().click(function(e) {
				e.stopPropagation();
				section_groups.push($(this).data('listid'));
				console.log(section_groups);
				var find_div = $(this).find('svg');
				if (find_div.hasClass('white')) {
					find_div.removeClass('white');
					find_div.css('color', 'red');
				} else {
					find_div.addClass('white');
				}
			});
	$('#license>.viksit-multiselect-dropdown >.dropdown-menu>.dropdown-item')
			.unbind().click(function(e) {
				e.stopPropagation();
				licenses.push($(this).data('listid'));
				console.log(licenses);
				var find_div = $(this).find('svg');
				if (find_div.hasClass('white')) {
					find_div.removeClass('white');
					find_div.css('color', 'red');
				} else {
					find_div.addClass('white');
				}
			});

	$("#addUserFormId").unbind().submit(function(e) {
		e.stopPropagation();
		e.preventDefault();

		var name = $('#fullName').val();
		var email = $('#emailId').val();
		var pincode =$('#pinCode').val();
		var mobile=$('#phoneNo').val();
		var addLine1=$('#inputAddress1').val();
		var addLine2=$('#inputAddress2').val();
		
	
		var user_type_arr = [] 
		user_type_arr.push({name: "STUDENT", id: 14, is_mapped: false});
		
		
		var userObject = {
				name :name,
				email : email,
				mobile : mobile,
				groups : section_groups,
				units : units,
				job_roles : jobRoles,
				licenses : licenses,
				address_line_1 : addLine1,
				address_line_2 : addLine2,
				pincode :pincode,
				user_types:user_type_arr
			};
		
		var userObjData = $.param({
			user_object : JSON.stringify(userObject)
		});
		$.ajax({
					type: 'POST',
					url : 'http://192.168.1.13:8080/istar/rest/user/create/3',
					data : userObjData,
				}).success(function(result) {
					 alert("success"+result);
		
		
			 
		});
		
		
		
		
		
		

		
		
		
	});

}
