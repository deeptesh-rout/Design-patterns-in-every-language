class HealthCheckSingleton
  @@instance = nil
  attr_reader :servers

  def self.instance
    @@instance ||= new
  end

  def initialize
    @servers = []
  end

  def add_server
    @servers.push('Server 1', 'Server 2')
  end

  def change_server
    @servers.pop
    @servers.push('Server 5')
  end
end

# Client code
hc1 = HealthCheckSingleton.instance
hc1.add_server

hc2 = HealthCheckSingleton.instance
hc2.add_server

puts hc1.servers
puts hc2.servers
  