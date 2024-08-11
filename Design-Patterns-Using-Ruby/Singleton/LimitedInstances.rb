class LimitedInstances
  @@instances = []
  LIMIT = 4

  private_class_method :new

  def self.get_instance
    if @@instances.length < LIMIT
      instance = new
      @@instances.push(instance)
      puts 'Instance created.'
      instance
    else
      raise 'Instance Limit reached.'
    end
  end
end

# Client code
begin
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
  LimitedInstances.get_instance
rescue StandardError => e
  puts e.message
end
