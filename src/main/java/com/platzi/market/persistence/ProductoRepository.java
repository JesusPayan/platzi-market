    package com.platzi.market.persistence;

    import com.platzi.market.domain.Product;
    import com.platzi.market.domain.repository.ProductRepository;
    import com.platzi.market.persistence.crud.ProductoCrudRepository;
    import com.platzi.market.persistence.entity.Producto;
    import com.platzi.market.persistence.mapper.ProductMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.Optional;
    /*Esta clase se utiliza para implementar los metodos desarrollados en la interfaz productoCrudRepository*/
    @Repository
    public class ProductoRepository implements ProductRepository {
                /*Crea una instancia de la interfaz productoCrudRepository*/
                @Autowired
                private ProductoCrudRepository productoCrudRepository;
                @Autowired
                private ProductMapper mapper;
    @Override
        public List<Product> getAll(){/*retorna una lista con todos los productos .*/
                List<Producto> productos = (List<Producto>)productoCrudRepository.findAll();
                return mapper.toProducts(productos);
        }

        @Override
        public Optional<List<Product>> getByCategory(int categoryId) {
              List<Producto>productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
              return Optional.of(mapper.toProducts(productos));
        }

        @Override
        public Optional<List<Product>> getScarseProdcuts(int quantity) {

            Optional<List<Producto>> productos =productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
                return productos.map(prods ->mapper.toProducts(prods));
        }

        @Override
        public Optional<Product> getProduct(int productId) {
                return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));

        }

        @Override
        public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
            return mapper.toProduct(productoCrudRepository.save(producto));
        }

        @Override
        public void delete(int productId) {
            productoCrudRepository.deleteById(productId);
        }

        /*este codigo crea un a funcion para regresar una lista de prodcutos ordenados por categoria*/

        /*

        public Optional<List<Producto>>getByCantidadAndStockLessAndEstado(int cantidadStock) {
            return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
        }/*Aqui es donde se implementa el metodo creado en la interfaz ProductoCrudRepository*/


       /* public Producto save(Producto producto){
            return productoCrudRepository.save(producto);
        }
    */

    }
