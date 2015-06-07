package br.com.gerenciador.reserva.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gerenciador.reserva.bo.Reserva;
import br.com.gerenciador.reserva.service.ReservaService;

@FacesConverter(forClass = Reserva.class)
public class ReservaConverter implements Converter {

	private ReservaService reservaService;
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		Reserva reserva = null;
		try {
			if(value != null && !value.isEmpty()){
				reserva = (Reserva) uiComponent.getAttributes().get(value);
				if(reserva == null){
					reservaService = new ReservaService();
					//TODO IMPLEMENTAR BUSCA POR ID
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reserva;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		if (object instanceof Reserva) {
			Reserva reserva = (Reserva) object;
			if(reserva.getId() != null){
				uiComponent.getAttributes().put(reserva.getId().toString(), reserva);
				return reserva.getId().toString();
			}
		}
		return null;
	}

}
