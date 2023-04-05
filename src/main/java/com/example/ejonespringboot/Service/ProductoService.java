package com.example.ejonespringboot.Service;


import com.example.ejonespringboot.Model.Producto;
import com.example.ejonespringboot.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepo;

    public Producto crearProducto(Producto producto){

        return productoRepo.save(producto);
    }

    public void borrarProducto(Long id){

        productoRepo.deleteById(id);
    }

    public List<Producto> listarProductos(){

        return  productoRepo.findAll();
    }

    public Producto buscarProductoId(Long id){

        return  productoRepo.findById(id).orElse(null);
    }

    public void modificarProducto(Producto producto) {
        // Se busca la persona en la base de datos por su ID
        Optional<Producto> productoEncontrado =
                productoRepo.findById(producto.getId());

        if(productoEncontrado.isPresent()) {
            // Si se encontró la persona, se actualizan sus datos
            Producto productoActualizado = productoEncontrado.get();
            productoActualizado.setNombre(producto.getNombre());
            productoActualizado.setPrecio(producto.getPrecio());
            productoActualizado.setCodigo(producto.getCodigo());
            productoActualizado.setEmpresa(producto.getEmpresa());
            productoActualizado.setLote(producto.getLote());
            productoActualizado.setNombredueno(producto.getNombredueno());



            // Aquí se pueden actualizar más campos según la necesidad
            /*productoRepo.save(productoActualizado);*/
        } else {
            // Si no se encontró la persona, se puede lanzar una excepción o manejar el error de otra forma
            throw new NoSuchElementException("No se encontró la persona con ID " + producto.getId());
        }
    }

    //Este metodo es sin DTO
   /* public Producto login(String user, String password){
      return productoRepo.findByloteandnombredueno(lote, nombredueno);
    }*/

    //Este metodo es con DTO
    /*public ProductoDTO login(String lote, String nombredueno){

        Producto producto =  productoRepo.findByloteandnombredueno(lote, nombredueno);
        ProductoDTO productoDTO = new ProductoDTO(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getCodigo(), producto.getEmpresa());

        return productoDTO;
    }*/


}
