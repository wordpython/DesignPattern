package com.wordpython.responsibilitychain;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个请求
		PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);
		PurchaseRequest purchaseRequest1 = new PurchaseRequest(1, 2, 1);
		//创建相关的审批人
		DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
		CollegeApprover collegeApprover = new CollegeApprover("李院长");
		ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校长");
		SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("袁校长");
	
		//将各个审批级别的下一个设置好（下面设置为环状处理，
		// 否则要指定最低级的初始审批类，这样就形成了单向链表）
		departmentApprover.setApprover(collegeApprover);
		collegeApprover.setApprover(viceSchoolMasterApprover);
		viceSchoolMasterApprover.setApprover(schoolMasterApprover);
		schoolMasterApprover.setApprover(departmentApprover);

		//单向链表审批方式，只能由departmentApprover开始发起processRequest
		//因为departmentApprover是最低级审批类，否则可能报空指针异常
		departmentApprover.processRequest(purchaseRequest);
		viceSchoolMasterApprover.processRequest(purchaseRequest);
	}
}
