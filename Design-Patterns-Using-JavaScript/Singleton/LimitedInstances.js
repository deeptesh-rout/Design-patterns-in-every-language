class LimitedInstances {
    static instances = [];
    static limit = 4;

    constructor() {}

    static getInstance() {
        if (LimitedInstances.instances.length < LimitedInstances.limit) {
            const instance = new LimitedInstances();
            LimitedInstances.instances.push(instance);
            return instance;
        } else {
            throw new Error("Instance Limit reached");
        }
    }
}

// Client code
try {
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
    LimitedInstances.getInstance();
} catch (error) {
    console.log(error.message);
}
