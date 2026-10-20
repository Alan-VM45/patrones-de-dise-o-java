package patrones.estructurales.bridge;

public final class Demo {
    interface Canal { String enviar(String destino, String mensaje); }
    static final class Correo implements Canal {
        public String enviar(String destino, String mensaje) { return "Correo a " + destino + ": " + mensaje; }
    }
    static final class SMS implements Canal {
        public String enviar(String destino, String mensaje) { return "SMS a " + destino + ": " + mensaje; }
    }
    static final class AvisoPedido {
        private final Canal canal;
        AvisoPedido(Canal canal) { this.canal = canal; }
        String pedidoEnviado(String cliente, String numero) {
            return canal.enviar(cliente, "Tu pedido " + numero + " fue enviado");
        }
    }

    public static void main(String[] args) {
        String correo = new AvisoPedido(new Correo()).pedidoEnviado("ana@ejemplo.com", "A-104");
        String sms = new AvisoPedido(new SMS()).pedidoEnviado("555-0101", "A-104");
        System.out.println("Aviso de pedido por correo: " + correo);
        System.out.println("El mismo aviso por SMS: " + sms);
        System.out.println("El contenido del aviso y el canal de envio pueden variar por separado.");
    }
}