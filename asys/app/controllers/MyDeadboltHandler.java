package controllers;

import models.deadbolt.RoleHolder;
import play.mvc.Controller;
import controllers.deadbolt.DeadboltHandler;
import controllers.deadbolt.ExternalizedRestrictionsAccessor;
import controllers.deadbolt.RestrictedResourcesHandler;

public class MyDeadboltHandler extends Controller implements DeadboltHandler {

	public static void index() {
		render();
	}

	@Override
	public void beforeRoleCheck() {
		// TODO Auto-generated method stub

	}

	@Override
	public RoleHolder getRoleHolder() {
		return GlobalController.usuarioConectado();
	}

	@Override
	public void onAccessFailure(String controllerClassName) {
		flash.put("mensaje",
				"Para continuar es necesario que se conecte al sistema");
		session.put("url", "GET".equals(request.method) ? request.url : "/");
		render("@Secure.login");

	}

	@Override
	public ExternalizedRestrictionsAccessor getExternalizedRestrictionsAccessor() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public RestrictedResourcesHandler getRestrictedResourcesHandler() {

		return null;
		//return new MyRestrictedResourcesHandler();
	}
	

}
