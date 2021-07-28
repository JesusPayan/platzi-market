package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository <Compra,String>{
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
