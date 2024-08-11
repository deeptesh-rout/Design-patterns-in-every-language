class HealthCheckSingleton {
    constructor() {
        this.servers = [];
    }

    static getInstance() {
        if (!this._instance) {
            this._instance = new HealthCheckSingleton();
        }
        return this._instance;
    }

    addServer() {
        this.servers.push("Server 1", "Server 2");
    }

    changeServer() {
        this.servers.pop();
        this.servers.push("Server 5");
    }

    getServers() {
        return this.servers;
    }
}

// Client code
const hc1 = HealthCheckSingleton.getInstance();
hc1.addServer();

const hc2 = HealthCheckSingleton.getInstance();
hc2.addServer();

console.log(hc1.getServers());
console.log(hc2.getServers());

/*
[ 'Server 1', 'Server 2', 'Server 1', 'Server 2' ]
[ 'Server 1', 'Server 2', 'Server 1', 'Server 2' ]
*/