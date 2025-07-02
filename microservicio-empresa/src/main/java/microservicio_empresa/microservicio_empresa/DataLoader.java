package microservicio_empresa.microservicio_empresa;

import microservicio_empresa.microservicio_empresa.model.Empresa;
import microservicio_empresa.microservicio_empresa.repository.EmpresaRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public void run(String... args) {
        Faker faker = new Faker();
        Random random = new Random();

        int empresasCreadas = 0;
        while (empresasCreadas < 20) {
            int rut = 10000000 + random.nextInt(8999999);
            int dv = calcularDV(rut);
            if (dv == -1)
                continue;
            Empresa empresa = new Empresa();
            empresa.setNombreEmp(faker.company().name());
            empresa.setRutEmp(rut);
            empresa.setDvEmp(dv);
            empresa.setDirEmp(faker.address().fullAddress());
            empresaRepository.save(empresa);
            empresasCreadas++;
        }
    }

    private int calcularDV(int rut) {
        int suma = 0;
        int multiplicador = 2;
        while (rut > 0) {
            suma += (rut % 10) * multiplicador;
            rut /= 10;
            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
        }

        int resto = suma % 11;
        int dv = 11 - resto;

        if (dv >= 1 && dv <= 9) {
            return dv;
        }
        return -1;
    }
}
