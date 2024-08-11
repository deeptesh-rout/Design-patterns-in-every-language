class LimitedInstances {
    private static var instances: [LimitedInstances] = []
    private static let limit = 4

    private init() {}

    static func getInstance() -> LimitedInstances {
        if instances.count < limit {
            let instance = LimitedInstances()
            instances.append(instance)
            return instance
        } else {
            fatalError("Instance Limit reached")
        }
    }
}

do {
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
    _ = LimitedInstances.getInstance()
} catch {
    print(error.localizedDescription)
}
