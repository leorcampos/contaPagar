package testePratico.ContaPagar.framework.util;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;


public class ObjectConvert {

	public static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parserObjeto(O origem, Class<D> destino) {
		return mapper.map(origem, destino);
	}
	
	public static <O , D> List<D> parserListObjeto(List<O> listOrigem, Class<D> destino){
		List<D> destinacaoOBjetos = new ArrayList<D>();
		
		for(Object origem: listOrigem) {
			destinacaoOBjetos.add(mapper.map(origem, destino));
		}
		
		return destinacaoOBjetos;
	}
}