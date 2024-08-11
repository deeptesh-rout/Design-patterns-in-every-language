class GodsObject
    def initialize
        @data = []
        @user = User.new
        @db = Database.new
        @mailer = Mailer.new
    end
  
    def process_data
        # Process data
        @db.connect
        @user.authenticate
        @data = @db.query
        @db.disconnect
    end
  
    def validate_data
        # Validate data
        @user.authorize
        @db.connect
        @db.validate
        @db.disconnect
    end
  
    def send_notification
        # Send notification
        @user.authorize
        @db.connect
        data = @db.query
        @mailer.send_email(data)
        @db.disconnect
    end
  
    # And so on...
end
