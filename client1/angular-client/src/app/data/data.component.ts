import { Component, OnInit } from '@angular/core';
import { Kafka } from 'kafkajs';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.scss']
})
export class DataComponent implements OnInit {
  public message: string = "fdghdfhdhd";

  private kafka: Kafka;

  constructor() { }

  public ngOnInit(): void {
    this.kafka = new Kafka({
      clientId: 'angular-app',
      brokers: ['kafka1:9092', 'kafka2:9092']
    })

    this.initConsumer();
  }

  private async initConsumer(): Promise<void> {
    const consumer = this.kafka.consumer({ groupId: 'client-group' })

    await consumer.connect()
    await consumer.subscribe({ topic: 'temp', fromBeginning: true })

    await consumer.run({
      eachMessage: async ({ topic, partition, message }) => {
        this.message = message.value.toString()
      },
    })
  }
}
