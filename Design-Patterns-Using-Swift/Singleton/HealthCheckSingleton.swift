class HealthCheckSingleton {
    private static var instance: HealthCheckSingleton?
    private var servers: [String] = []

    private init() {
        self.servers = []
    }

    static func getInstance() -> HealthCheckSingleton {
        if instance == nil {
            instance = HealthCheckSingleton()
        }
        return instance!
    }

    func addServer() {
        self.servers.append("Server 1")
        self.servers.append("Server 2")
    }

    func changeServer() {
        _ = self.servers.popLast()
        self.servers.append("Server 5")
    }

    func getServers() -> [String] {
        return self.servers
    }
}

// Client Code
let hc1 = HealthCheckSingleton.getInstance()
hc1.addServer()

let hc2 = HealthCheckSingleton.getInstance()
hc2.addServer()

print(hc1.getServers())
print(hc2.getServers())

/*
["Server 1", "Server 2", "Server 1", "Server 2"]
["Server 1", "Server 2", "Server 1", "Server 2"]
*/