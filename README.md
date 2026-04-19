# Padroes_de_Projeto

📖 Descrição Técnica do Projeto
O SmartHome SOLID Hub é uma solução de software desenhada para resolver o problema da fragmentação em sistemas de automação residencial. Em um cenário onde cada fabricante possui sua própria API, este projeto utiliza Padrões de Projeto (Design Patterns) para criar uma camada de abstração que unifica o controle de dispositivos e a gestão de eventos.

🏭 1. Fabric 
Utilizado para centralizar a lógica de criação de dispositivos. Em vez do sistema principal instanciar classes específicas (como SamsungLight), ele solicita à DeviceFactory um objeto que implemente a interface SmartDevice. Isso facilita a expansão para novas marcas no futuro.

🏢 2. Singleton
O sistema de log (HomeLogger) deve ser único. O Singleton garante que todas as partes do programa escrevam no mesmo arquivo ou console, evitando conflitos de escrita e economizando recursos de memória.

🛡️ 3. Proxy
Segurança é vital em uma casa inteligente. O SecurityProxy intercepta solicitações para dispositivos sensíveis (como fechaduras ou câmeras). Ele verifica as credenciais do usuário antes de permitir que o comando chegue ao objeto real.

🔌 4. Adapter
Muitos dispositivos vêm com métodos "estranhos" (ex: powerOn() em vez de liga()). O Adapter funciona como uma tomada universal, convertendo essas interfaces proprietárias para o padrão esperado pelo nosso sistema.

🎨 5. Decorator
Permite "envolver" uma funcionalidade básica com camadas extras sem alterar a classe original. Por exemplo, uma notificação de SMS simples pode ser decorada com uma camada de Criptografia ou uma camada de Prioridade Máxima.

📡 6. Observer
Fundamental para sensores. Quando o TemperatureSensor detecta uma alteração, ele não precisa saber quem são os interessados; ele simplesmente notifica todos os observadores registrados (como o Ar-condicionado ou o Painel do Usuário).
