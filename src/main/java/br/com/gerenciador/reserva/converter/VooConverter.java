package br.com.gerenciador.reserva.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gerenciador.reserva.bo.Voo;
import br.com.gerenciador.reserva.service.VooService;

@FacesConverter(forClass = Voo.class)
public class VooConverter implements Converter {

	private VooService vooService;
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		Voo voo = null;
		try {
			if(value != null && !value.isEmpty()){
				voo = (Voo) uiComponent.getAttributes().get(value);
				
				if(voo == null){
					vooService = new VooService();
					try {
						voo = vooService.buscarVooPorId(new Long(value));
					} catch (NumberFormatException e) {
						return null;
					}			
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voo;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		if(object instanceof Voo){
			Voo voo = (Voo) object;
			
			if(voo.getId() != null){
				uiComponent.getAttributes().put(voo.getId().toString(), voo);
				return voo.getId().toString();
			}		
		}
		return null;
	}

}
