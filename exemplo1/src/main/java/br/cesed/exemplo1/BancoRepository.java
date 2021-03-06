package br.cesed.exemplo1;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "banco", path = "banco")
public interface BancoRepository extends PagingAndSortingRepository<Banco, Integer> {
 

}
