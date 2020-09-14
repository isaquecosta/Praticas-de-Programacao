package br.cesed.exemplo1;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
@RepositoryRestResource(collectionResourceRel = "conta", path = "conta")
public interface ContaRepository extends PagingAndSortingRepository<Conta, Integer> {

}
 